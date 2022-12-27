package Delegation

interface Downloader{
    fun download()
}
interface Player{
    fun play()
}
class FileDownloader(private val file:String):Downloader{
    override fun download() {
        println("$file is downloaded")
    }

}
class FilePlayer(private val file:String):Player{
    override fun play() {
        println("$file is played")
    }

}


class MediaFile(
    private val downloader:Downloader,
    private val player: Player): Downloader by downloader,Player by player {
//    override fun download() {
//        downloader.download()
//    }
//
//    override fun play() {
//        player.play()
//    }
}
fun main(){
    val file="file1.mkv"
    val mediaFile=MediaFile(FileDownloader(file),FilePlayer(file))
    mediaFile.download()
    mediaFile.play()

}