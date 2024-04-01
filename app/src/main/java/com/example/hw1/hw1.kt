package com.example.hw1


open class Item(val name: String, val price: Double)

// Food sınıfı, Item sınıfından türetilmiş alt sınıf
class Food(name: String, price: Double, val weight: String) : Item(name, price)

// Cloth sınıfı, Item sınıfından türetilmiş alt sınıf
class Cloth(name: String, price: Double, val type: String) : Item(name, price)

// ShoppingList sınıfı
class ShoppingList {
    val List = mutableListOf<Item>()

    // Ürün ekleme fonksiyonu
    fun addItem(item : Item){
        List.add(item)
        println("${item.name} eklendi")
    }
    // Ürünleri gösterme fonksiyonu
    fun displayItem(){
        for (i in List){
            if(i is Food) {
                println("${i.name} , ${i.price}$, ${i.weight}kg")
            }

            if(i is Cloth) {
                println("${i.name} , ${i.price}$, ${i.type}")
            }
            }

      }

    // Ürün silme fonksiyonu
    fun deleteItem(index:Int){
        if(index>=0 && index<List.size) {
            val silinenDeger = List.removeAt(index)
            println("${silinenDeger.name} silindi.")
        }
        else{
          println("Geçersiz index")
        }
    }
}

fun main() {
    val shoppingList = ShoppingList()

    var secim: Int
    do{
        println("1) Add Item")
        println("2) Display Item")
        println("3) Delete Item")
        println("4) Exit")
        print("Secim yapiniz: ")
        var secim = readLine()!!.toInt()
        when(secim){
            1-> {
                println("Urun cesidi: ")
                println("1:Food")
                println("2:Cloth")
                print("Secim yapin: ")
                val itemType = readLine()!!.toInt()
                if (itemType != 1 && itemType != 2){
                    println("Hatalı secim")
                }
                when(itemType){
                    1-> {
                        print("Name girin: ")
                        val name = readLine()!!.toString()
                        print("Weight girin: ")
                        val weight = readLine()!!.toDouble()
                        print("Price girin: ")
                        val price = readLine()!!.toString()
                        shoppingList.addItem(Food(name, weight, price))
                    }
                    2->{
                        print("Name girin: ")
                        val name = readLine()!!.toString()
                        print("Type girin: ")
                        val type = readLine()!!.toDouble()
                        print("Price girin: ")
                        val price = readLine()!!.toString()
                        shoppingList.addItem(Cloth(name, type, price))

                    }
                }


            }

            2->{
                println("Alışveriş Listesi: ")
                shoppingList.displayItem()
            }
            3->{
                println("Silinecek ürünü gir: ")
                val index = readLine()!!.toInt()-1
                shoppingList.deleteItem(index)
            }

        }
    } while (secim != 4)


}

