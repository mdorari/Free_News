package com.mehrdad.freenews.data.model

data class Country(
    val name: String,
    val initials: String
) {
    companion object {
        val listOfCountries = listOf(
            Country(
                name = "United Arab Emirates",
                initials = "ae"
            ),
            Country(
                name = "United Arab Emirates",
                initials = "ae"
            ),
            Country(
                name = "Argentina",
                initials = "ar"
            ),
            Country(
                name = "Austria",
                initials = "at"
            ),
            Country(
                name = "Australia",
                initials = "au"
            ),
            Country(
                name = "Belgium",
                initials = "be"
            ),
            Country(
                name = "Brazil",
                initials = "br"
            ),
            Country(
                name = "Canada",
                initials = "ca"
            ),
            Country(
                name = "Switzerland",
                initials = "ch"
            ),
            Country(
                name = "Chile",
                initials = "cl"
            ),
            Country(
                name = "China",
                initials = "cn"
            ),
            Country(
                name = "Colombia",
                initials = "co"
            ),
            Country(
                name = "Costa Rica",
                initials = "cr"
            ),
            Country(
                name = "Czech Republic",
                initials = "cz"
            ),
            Country(
                name = "Germany",
                initials = "de"
            ),
            Country(
                name = "Egypt",
                initials = "eg"
            ),
            Country(
                name = "Spain",
                initials = "es"
            ),
            Country(
                name = "France",
                initials = "fr"
            ),
            Country(
                name = "United Kingdom",
                initials = "gb"
            ),
            Country(
                name = "Greece",
                initials = "gr"
            ),
            Country(
                name = "Hong Kong",
                initials = "hk"
            ),
            Country(
                name = "Hungary",
                initials = "hu"
            ),
            Country(
                name = "Indonesia",
                initials = "id"
            ),
            Country(
                name = "Ireland",
                initials = "ie"
            ),
            Country(
                name = "Israel",
                initials = "il"
            ),
            Country(
                name = "India",
                initials = "in"
            ),
            Country(
                name = "Italy",
                initials = "it"
            ),
            Country(
                name = "Japan",
                initials = "jp"
            ),
            Country(
                name = "South Korea",
                initials = "kr"
            ),
            Country(
                name = "Lithuania",
                initials = "lt"
            ),
            Country(
                name = "Latvia",
                initials = "lv"
            ),
            Country(
                name = "Macau",
                initials = "mo"
            ),
            Country(
                name = "Mexico",
                initials = "mx"
            ),
            Country(
                name = "Malaysia",
                initials = "my"
            ),
            Country(
                name = "Nigeria",
                initials = "ng"
            ),
            Country(
                name = "Netherlands",
                initials = "nl"
            ),
            Country(
                name = "Norway",
                initials = "no"
            ),
            Country(
                name = "New Zealand",
                initials = "nz"
            ),
            Country(
                name = "Philippines",
                initials = "ph"
            ),
            Country(
                name = "Poland",
                initials = "pl"
            ),
            Country(
                name = "Portugal",
                initials = "pt"
            ),
            Country(
                name = "Romania",
                initials = "ro"
            ),
            Country(
                name = "Russia",
                initials = "ru"
            ),
            Country(
                name = "Saudi Arabia",
                initials = "sa"
            ),
            Country(
                name = "Sweden",
                initials = "se"
            ),
            Country(
                name = "Singapore",
                initials = "sg"
            ),
            Country(
                name = "Slovenia",
                initials = "si"
            ),
            Country(
                name = "Slovakia",
                initials = "sk"
            ),
            Country(
                name = "Thailand",
                initials = "th"
            ),
            Country(
                name = "Turkey",
                initials = "tr"
            ),
            Country(
                name = "Taiwan",
                initials = "tw"
            ),
            Country(
                name = "Ukraine",
                initials = "ua"
            ),
            Country(
                name = "United States",
                initials = "us"
            ),
            Country(
                name = "Venezuela",
                initials = "ve"
            ),
            Country(
                name = "South Africa",
                initials = "za"
            )
        )
    }
}



//
//// Function to convert country name to its initials
//fun getCountryInitials(countryName: String): String {
//    return when (countryName) {
//        Country.UnitedArabEmirates.name -> Country.UnitedArabEmirates.initials
//        Country.Argentina.name -> Country.Argentina.initials
//        Country.Austria.name -> Country.Austria.initials
//        Country.Australia.name -> Country.Australia.initials
//        Country.Belgium.name -> Country.Belgium.initials
//        Country.Brazil.name -> Country.Brazil.initials
//        Country.Canada.name -> Country.Canada.initials
//        Country.Switzerland.name -> Country.Switzerland.initials
//        Country.Chile.name -> Country.Chile.initials
//        Country.China.name -> Country.China.initials
//        Country.Colombia.name -> Country.Colombia.initials
//        Country.CostaRica.name -> Country.CostaRica.initials
//        Country.CzechRepublic.name -> Country.CzechRepublic.initials
//        Country.Germany.name -> Country.Germany.initials
//        Country.Egypt.name -> Country.Egypt.initials
//        Country.Spain.name -> Country.Spain.initials
//        Country.France.name -> Country.France.initials
//        Country.UnitedKingdom.name -> Country.UnitedKingdom.initials
//        Country.Greece.name -> Country.Greece.initials
//        Country.HongKong.name -> Country.HongKong.initials
//        Country.Hungary.name -> Country.Hungary.initials
//        Country.Indonesia.name -> Country.Indonesia.initials
//        Country.Ireland.name -> Country.Ireland.initials
//        Country.Israel.name -> Country.Israel.initials
//        Country.India.name -> Country.India.initials
//        Country.Italy.name -> Country.Italy.initials
//        Country.Japan.name -> Country.Japan.initials
//        Country.SouthKorea.name -> Country.SouthKorea.initials
//        Country.Lithuania.name -> Country.Lithuania.initials
//        Country.Latvia.name -> Country.Latvia.initials
//        Country.Macau.name -> Country.Macau.initials
//        Country.Mexico.name -> Country.Mexico.initials
//        Country.Malaysia.name -> Country.Malaysia.initials
//        Country.Nigeria.name -> Country.Nigeria.initials
//        Country.Netherlands.name -> Country.Netherlands.initials
//        Country.Norway.name -> Country.Norway.initials
//        Country.NewZealand.name -> Country.NewZealand.initials
//        Country.Philippines.name -> Country.Philippines.initials
//        Country.Poland.name -> Country.Poland.initials
//        Country.Portugal.name -> Country.Portugal.initials
//        Country.Romania.name -> Country.Romania.initials
//        Country.Russia.name -> Country.Russia.initials
//        Country.SaudiArabia.name -> Country.SaudiArabia.initials
//        Country.Sweden.name -> Country.Sweden.initials
//        Country.Singapore.name -> Country.Singapore.initials
//        Country.Slovenia.name -> Country.Slovenia.initials
//        Country.Slovakia.name -> Country.Slovakia.initials
//        Country.Thailand.name -> Country.Thailand.initials
//        Country.Turkey.name -> Country.Turkey.initials
//        Country.Taiwan.name -> Country.Taiwan.initials
//        Country.Ukraine.name -> Country.Ukraine.initials
//        Country.UnitedStates.name -> Country.UnitedStates.initials
//        Country.Venezuela.name -> Country.Venezuela.initials
//        Country.SouthAfrica.name -> Country.SouthAfrica.initials
//        else -> ""
//    }
//}
//
//
