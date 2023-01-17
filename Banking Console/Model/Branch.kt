package Model

data class Branch(val branchName: String, var reserveAmount: Long, val branchCode: String) {
    val accounts = ArrayList<Long>()
    var branchProfit = 0

    override fun toString(): String {
        return """
               BranchName :$branchName
               IFSC Code='$branchCode
               Accounts=$accounts
               ReserveAmount=$reserveAmount
               BranchProfit=$branchProfit
               """.trimIndent()
    }
}