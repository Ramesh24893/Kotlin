package Model

data class DebitCardForm(
     var accNum: Long = 0,
    val branchCode: String,
     val accountType: String,
    val cardHolderName: String ,
     val userId: String) {
}