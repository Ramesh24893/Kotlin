package Model

import java.time.LocalDate

data class DebitCard(
    val cardNumber: Long,
     val expiryDate: LocalDate,
     val ccv: Int)
