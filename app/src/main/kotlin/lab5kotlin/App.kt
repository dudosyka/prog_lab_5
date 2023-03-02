/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package lab5kotlin

import lab5kotlin.collection.Collection
import lab5kotlin.collection.exceptions.ValidationFieldException
import lab5kotlin.console.CollectionPrinter

class App {
    val greeting: String
        get() {
            return "Hello World!"
        }

    var collection: Collection<Human> = Collection<Human>()

    fun createCollection() {
        val humanItem = Human()
        val onCreateHuman = mutableMapOf<String, Any?>()
        onCreateHuman["id"] = 1
        onCreateHuman["name"] = "Alex"
        onCreateHuman["age"] = "18"
        try {
            humanItem.init(onCreateHuman)
            collection.addItem(humanItem)
        } catch (e: ValidationFieldException) {
            println("Item creation failed!")
            println("Validation failed when processing ${e.field.name} field")
            println("Input value: ${e.validatedValue} must be ${e.field.type} type")
        }
    }

    fun printCollection() {
        val printer = CollectionPrinter()
        printer.print(collection)
    }
}

fun main() {
    val app = App()
    println(app.greeting)
    app.createCollection()
    app.printCollection()
}
