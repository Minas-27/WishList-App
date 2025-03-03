package com.example.mywishlist.data

data class Wish(
    val id: Long = 0L,
    val title : String = "",
    val description: String = ""
)

object DummyWish {
    val wishList = listOf(
        Wish(1,"ADRS", "ALALACAKNCLANLA"),
        Wish(2,"ADRS", "ALALACAKNCLANLA"),
        Wish(3,"ADRS", "ALALACAKNCLANLA"),
        Wish(4,"ADRS", "ALALACAKNCLANLA")
    )
}

