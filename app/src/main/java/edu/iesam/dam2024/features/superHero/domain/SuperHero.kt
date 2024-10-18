package edu.iesam.dam2024.features.superHero.domain

data class SuperHero(
    val id: String,
    val name: String,
    val slug: String,
    val powerstats: PowerStats,
    val appearance: Appearance,
    val biography: Biography,
    val work: Work,
    val connections: Connections,
    val images: Images
)

data class PowerStats(
    val intelligence: Int,
    val strength: Int,
    val speed: Int,
    val durability: Int,
    val power: Int,
    val combat: Int
) {
    override fun toString(): String {
        return "Inteligencia= $intelligence\n Fuerza= $strength\n Velocidad= $speed\n Durabilidad= $durability\n Poder= $power\n Combate= $combat"
    }
}

data class Appearance(
    val gender: String,
    val race: String?,
    val height: List<String>,
    val weight: List<String>,
    val eyeColor: String,
    val hairColor: String
) {
    override fun toString(): String {
        return "Genero='$gender'\nRaza=$race\nAltura=$height\nPeso=$weight\nColor de ojos='$eyeColor'\nColor de cabello='$hairColor'"
    }
}

data class Biography(
    val fullName: String,
    val alterEgos: String,
    val aliases: List<String>,
    val placeOfBirth: String,
    val firstAppearance: String,
    val publisher: String,
    val alignment: String
) {
    override fun toString(): String {
        return "Verdadero nombre='$fullName'\nalterEgos='$alterEgos'\naliases=$aliases\nLugar de nacimiento='$placeOfBirth'\nPrimera aparicion='$firstAppearance'\nCasa='$publisher'\nLado='$alignment'"
    }
}

data class Work(
    val occupation: String,
    val base: String
) {
    override fun toString(): String {
        return "Ocupacion= $occupation\nbase='$base'"
    }
}

data class Connections(
    val groupAffiliation: String,
    val relatives: String
) {
    override fun toString(): String {
        return "Grupo de afiliacion='$groupAffiliation'\nrelatives='$relatives'"
    }
}

data class Images(
    val xs: String,
    val sm: String,
    val md: String,
    val lg: String
)
