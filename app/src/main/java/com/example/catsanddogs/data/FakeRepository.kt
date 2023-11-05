package com.example.catsanddogs.data

import com.example.catsanddogs.R

class FakeRepository {
    fun loadData(): List<Animal> {
        return listOf(
            Animal(R.drawable.cats1, "Lucy", 3, AnimalType.CAT),
            Animal(R.drawable.cats2, "Tia", 4, AnimalType.CAT),
            Animal(R.drawable.cats3, "Fluffy", 3, AnimalType.CAT),
            Animal(R.drawable.cats4, "Cutie", 6, AnimalType.CAT),
            Animal(R.drawable.cats5, "Sara", 7, AnimalType.CAT),
            Animal(R.drawable.cats6, "Bella", 8, AnimalType.CAT),
            Animal(R.drawable.dogs1, "Tiger", 3, AnimalType.DOG),
            Animal(R.drawable.dogs2, "Scooby", 4, AnimalType.DOG),
            Animal(R.drawable.dogs3, "Tommy", 6, AnimalType.DOG),
            Animal(R.drawable.dogs4, "Mikey", 3, AnimalType.DOG),
            Animal(R.drawable.dogs5, "Tuffy", 2, AnimalType.DOG),
            Animal(R.drawable.dogs6, "Becky", 3, AnimalType.DOG)

        )
    }
}