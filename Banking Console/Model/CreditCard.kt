package Model

import java.time.LocalDate

data class CreditCard(
    val cardNumber: Long,
    val expiryDate: LocalDate,
    val ccv: Int
)