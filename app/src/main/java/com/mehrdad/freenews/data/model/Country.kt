package com.mehrdad.freenews.data.model

sealed class Country(val name: String, val initials: String) {
    object UnitedArabEmirates : Country("United Arab Emirates", "ae")
    object Argentina : Country("Argentina", "ar")
    object Austria : Country("Austria", "at")
    object Australia : Country("Australia", "au")
    object Belgium : Country("Belgium", "be")
    object Brazil : Country("Brazil", "br")
    object Canada : Country("Canada", "ca")
    object Switzerland : Country("Switzerland", "ch")
    object Chile : Country("Chile", "cl")
    object China : Country("China", "cn")
    object Colombia : Country("Colombia", "co")
    object CostaRica : Country("Costa Rica", "cr")
    object CzechRepublic : Country("Czech Republic", "cz")
    object Germany : Country("Germany", "de")
    object Egypt : Country("Egypt", "eg")
    object Spain : Country("Spain", "es")
    object France : Country("France", "fr")
    object UnitedKingdom : Country("United Kingdom", "gb")
    object Greece : Country("Greece", "gr")
    object HongKong : Country("Hong Kong", "hk")
    object Hungary : Country("Hungary", "hu")
    object Indonesia : Country("Indonesia", "id")
    object Ireland : Country("Ireland", "ie")
    object Israel : Country("Israel", "il")
    object India : Country("India", "in")
    object Italy : Country("Italy", "it")
    object Japan : Country("Japan", "jp")
    object SouthKorea : Country("South Korea", "kr")
    object Lithuania : Country("Lithuania", "lt")
    object Latvia : Country("Latvia", "lv")
    object Macau : Country("Macau", "mo")
    object Mexico : Country("Mexico", "mx")
    object Malaysia : Country("Malaysia", "my")
    object Nigeria : Country("Nigeria", "ng")
    object Netherlands : Country("Netherlands", "nl")
    object Norway : Country("Norway", "no")
    object NewZealand : Country("New Zealand", "nz")
    object Philippines : Country("Philippines", "ph")
    object Poland : Country("Poland", "pl")
    object Portugal : Country("Portugal", "pt")
    object Romania : Country("Romania", "ro")
    object Russia : Country("Russia", "ru")
    object SaudiArabia : Country("Saudi Arabia", "sa")
    object Sweden : Country("Sweden", "se")
    object Singapore : Country("Singapore", "sg")
    object Slovenia : Country("Slovenia", "si")
    object Slovakia : Country("Slovakia", "sk")
    object Thailand : Country("Thailand", "th")
    object Turkey : Country("Turkey", "tr")
    object Taiwan : Country("Taiwan", "tw")
    object Ukraine : Country("Ukraine", "ua")
    object UnitedStates : Country("United States", "us")
    object Venezuela : Country("Venezuela", "ve")
    object SouthAfrica : Country("South Africa", "za")
}

// Function to convert country name to its initials
fun getCountryInitials(countryName: String): String {
    return when (countryName) {
        Country.UnitedArabEmirates.name -> Country.UnitedArabEmirates.initials
        Country.Argentina.name -> Country.Argentina.initials
        Country.Austria.name -> Country.Austria.initials
        Country.Australia.name -> Country.Australia.initials
        Country.Belgium.name -> Country.Belgium.initials
        Country.Brazil.name -> Country.Brazil.initials
        Country.Canada.name -> Country.Canada.initials
        Country.Switzerland.name -> Country.Switzerland.initials
        Country.Chile.name -> Country.Chile.initials
        Country.China.name -> Country.China.initials
        Country.Colombia.name -> Country.Colombia.initials
        Country.CostaRica.name -> Country.CostaRica.initials
        Country.CzechRepublic.name -> Country.CzechRepublic.initials
        Country.Germany.name -> Country.Germany.initials
        Country.Egypt.name -> Country.Egypt.initials
        Country.Spain.name -> Country.Spain.initials
        Country.France.name -> Country.France.initials
        Country.UnitedKingdom.name -> Country.UnitedKingdom.initials
        Country.Greece.name -> Country.Greece.initials
        Country.HongKong.name -> Country.HongKong.initials
        Country.Hungary.name -> Country.Hungary.initials
        Country.Indonesia.name -> Country.Indonesia.initials
        Country.Ireland.name -> Country.Ireland.initials
        Country.Israel.name -> Country.Israel.initials
        Country.India.name -> Country.India.initials
        Country.Italy.name -> Country.Italy.initials
        Country.Japan.name -> Country.Japan.initials
        Country.SouthKorea.name -> Country.SouthKorea.initials
        Country.Lithuania.name -> Country.Lithuania.initials
        Country.Latvia.name -> Country.Latvia.initials
        Country.Macau.name -> Country.Macau.initials
        Country.Mexico.name -> Country.Mexico.initials
        Country.Malaysia.name -> Country.Malaysia.initials
        Country.Nigeria.name -> Country.Nigeria.initials
        Country.Netherlands.name -> Country.Netherlands.initials
        Country.Norway.name -> Country.Norway.initials
        Country.NewZealand.name -> Country.NewZealand.initials
        Country.Philippines.name -> Country.Philippines.initials
        Country.Poland.name -> Country.Poland.initials
        Country.Portugal.name -> Country.Portugal.initials
        Country.Romania.name -> Country.Romania.initials
        Country.Russia.name -> Country.Russia.initials
        Country.SaudiArabia.name -> Country.SaudiArabia.initials
        Country.Sweden.name -> Country.Sweden.initials
        Country.Singapore.name -> Country.Singapore.initials
        Country.Slovenia.name -> Country.Slovenia.initials
        Country.Slovakia.name -> Country.Slovakia.initials
        Country.Thailand.name -> Country.Thailand.initials
        Country.Turkey.name -> Country.Turkey.initials
        Country.Taiwan.name -> Country.Taiwan.initials
        Country.Ukraine.name -> Country.Ukraine.initials
        Country.UnitedStates.name -> Country.UnitedStates.initials
        Country.Venezuela.name -> Country.Venezuela.initials
        Country.SouthAfrica.name -> Country.SouthAfrica.initials
        else -> ""
    }
}


