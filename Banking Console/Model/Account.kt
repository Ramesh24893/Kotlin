package Model

import java.time.LocalDate
import java.util.*

  data class Account(
      val accHolderName: String,
      val accountNumber: Long,
      val mobileNumber: Long,
      var branchCode: String,
      val fatherName: String,
      var age: Int,
      val gender: String,
      val aadhaar: Long,
      val panNum: String,
      var city: String,
      var dateOfCreation: LocalDate,
      var balance: Long=0,
      var totalChargesPaid: Int=0,
      val transactions: LinkedList<String> = LinkedList<String>(),
      var accountType: String="",
      var withdrawLimit: Int=0,
      var depositLimit: Int =0,
      var transferLimit: Int=0,
      var minBalance: Int =0,
      var overDraftLimit: Int=0,
      var debtAmt: Int =0,
      var creditCard: CreditCard?=null,
      var debitCard: DebitCard?=null,
      var linkedUserId: String="",
){
//   constructor(  accHolderName: String, accountNumber: Long ,
//                 mobileNumber: Long ,
//                 branchCode: String,
//                 fatherName: String,
//                 age: Int ,
//                gender: String, aadhaar: Long,
//                 panNum: String,
//                 city: String,):this()

   override fun toString(): String {
    return """             ACCOUNT STATUS       

AccountHolderName   : $accHolderName
AccountNumber       : $accountNumber
MobileNumber        : $mobileNumber
BranchCode          : $branchCode
Father Name         : $fatherName
Age                 : $age
Gender              : $gender
City                : $city
Aadhaar Number      : $aadhaar
Pan Number          : $panNum
Balance             : $balance
Debt amount         : $debtAmt
Tax Payed           : $totalChargesPaid
OverDaftLimit       : $overDraftLimit
DateOfCreation      : $dateOfCreation
AccountType         : $accountType
CreditCard          : ${if (creditCard == null) "Nil" else "Yes"}
DebitCard           : ${if (debitCard == null) "Nil" else "Yes"}
Linked ID           : $linkedUserId"""
   }


 }