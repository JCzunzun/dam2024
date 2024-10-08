package edu.iesam.dam2024.features.superHero.data.remote

import edu.iesam.dam2024.features.superHero.domain.*

class SuperHeroMockRemoteDataSource {
    private val superHeros = listOf(
        SuperHero(
            id = "1",
            name = "A-Bomb",
            slug = "1-a-bomb",
            powerstats = PowerStats(
                intelligence = 38,
                strength = 100,
                speed = 17,
                durability = 80,
                power = 24,
                combat = 64
            ),
            appearance = Appearance(
                gender = "Male",
                race = "Human",
                height = listOf("6'8", "203 cm"),
                weight = listOf("980 lb", "441 kg"),
                eyeColor = "Yellow",
                hairColor = "No Hair"
            ),
            biography = Biography(
                fullName = "Richard Milhouse Jones",
                alterEgos = "No alter egos found.",
                aliases = listOf("Rick Jones"),
                placeOfBirth = "Scarsdale, Arizona",
                firstAppearance = "Hulk Vol 2 #2 (April, 2008) (as A-Bomb)",
                publisher = "Marvel Comics",
                alignment = "good"
            ),
            work = Work(
                occupation = "Musician, adventurer, author; formerly talk show host",
                base = "-"
            ),
            connections = Connections(
                groupAffiliation = "Hulk Family; Excelsior (sponsor), Avengers (honorary member); formerly partner of the Hulk, Captain America and Captain Marvel; Teen Brigade; ally of Rom",
                relatives = "Marlo Chandler-Jones (wife); Polly (aunt); Mrs. Chandler (mother-in-law); Keith Chandler, Ray Chandler, three unidentified others (brothers-in-law); unidentified father (deceased); Jackie Shorr (alleged mother; unconfirmed)"
            ),
            images =  "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/sm/1-a-bomb.jpg",

        ),
        SuperHero(
            id = "2",
            name = "Abe Sapien",
            slug = "2-abe-sapien",
            powerstats = PowerStats(
                intelligence = 88,
                strength = 28,
                speed = 35,
                durability = 65,
                power = 100,
                combat = 85
            ),
            appearance = Appearance(
                gender = "Male",
                race = "Icthyo Sapien",
                height = listOf("6'3", "191 cm"),
                weight = listOf("145 lb", "65 kg"),
                eyeColor = "Blue",
                hairColor = "No Hair"
            ),
            biography = Biography(
                fullName = "Abraham Sapien",
                alterEgos = "No alter egos found.",
                aliases = listOf("Langdon Everett Caul", "Abraham Sapien", "Langdon Caul"),
                placeOfBirth = "-",
                firstAppearance = "Hellboy: Seed of Destruction (1993)",
                publisher = "Dark Horse Comics",
                alignment = "good"
            ),
            work = Work(
                occupation = "Paranormal Investigator",
                base = "-"
            ),
            connections = Connections(
                groupAffiliation = "Bureau for Paranormal Research and Defense",
                relatives = "Edith Howard (wife, deceased)"
            ),
            images = "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/sm/2-abe-sapien.jpg",

        ),
        SuperHero(
            id = "3",
            name = "Abin Sur",
            slug = "3-abin-sur",
            powerstats = PowerStats(
                intelligence = 50,
                strength = 90,
                speed = 53,
                durability = 64,
                power = 99,
                combat = 65
            ),
            appearance = Appearance(
                gender = "Male",
                race = "Ungaran",
                height = listOf("6'1", "185 cm"),
                weight = listOf("200 lb", "90 kg"),
                eyeColor = "Blue",
                hairColor = "No Hair"
            ),
            biography = Biography(
                fullName = "",
                alterEgos = "No alter egos found.",
                aliases = listOf("Lagzia"),
                placeOfBirth = "Ungara",
                firstAppearance = "Showcase #22 (October, 1959)",
                publisher = "DC Comics",
                alignment = "good"
            ),
            work = Work(
                occupation = "Green Lantern, former history professor",
                base = "Oa"
            ),
            connections = Connections(
                groupAffiliation = "Green Lantern Corps, Black Lantern Corps",
                relatives = "Amon Sur (son), Arin Sur (sister), Thaal Sinestro (brother-in-law), Soranik Natu (niece)"
            ),
            images = "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/sm/3-abin-sur.jpg",

        )
    )

    fun getSupersHeros(): List<SuperHero> {
        return superHeros

    }

    fun getSuperHero(superHeroID: String): SuperHero? {
        return superHeros.firstOrNull { superHerp ->
            superHerp.id == superHeroID
        }
    }
}