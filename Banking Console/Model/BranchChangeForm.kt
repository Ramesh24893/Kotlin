package Model

data class BranchChangeForm (
     var accountNumber: Long,
     val currentBranchCode: String,
     val newBranchCode: String,
     val userId: String
        )