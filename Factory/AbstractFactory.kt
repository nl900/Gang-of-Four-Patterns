/*
Abstract factory is used for dependency injection / strategy, to create a whole family of objects that need to be of the same kind
and have common base classes
An interface that allows a family of closely related classes to be instantiated
The example below, the interface acts as a blueprint for what kind of car parts the independent factories should build and
from what arguments. The factories / subclasses will then build the parts based on the specific requirements and processes
 */

// defines the type of objects to be created
interface AlertDialog {
    fun show()  // defines the methods all objects created by the factory method must implement
}

// classes implement the interface define the type of objects created
class MaterialAlertDialog : AlertDialog {
    override fun show() {
        println("Showing Material Design Alert Dialog")
    }
}

class CupertinoAlertDialog : AlertDialog {
    override fun show() {
        println("Showing Cupertino Alert Dialog")
    }
}

// creator interface define the methods subclasses use to create objects
interface DialogFactory {
    fun createAlertDialog(): AlertDialog
}

// implement the creator interface implement of the factory method and determine the
// type of object created

class MaterialDialogFactory : DialogFactory {
    override fun createAlertDialog(): AlertDialog {
        return MaterialAlertDialog()
    }
}

class CupertinoDialogFactory : DialogFactory {
    override fun createAlertDialog(): AlertDialog {
        return CupertinoAlertDialog()
    }
}

  /*
    inline keyword eliminates the memory overhead for the memory allocation for the higher order function or lambda expression
    stored as objects. inline keyword requests the compiler to not allocate memory and copy the inlined code of the function at the
    calling place

    reified keyword allows the function to access the generic type M as a normal class in the function body at runTime
    otherwise it's only available at compile time and erased at runtime
    reified is only used with the inline keyword. Instructs the compiler to copy the function's bytecode to everywhere
    the function is invoked. The compiler knows the actual type passed as type argument with the reified type so it can
    modify the generated bytecode to use the corresponding class directly
 */
class DialogFactoryProvider {
    inline fun <reified F : DialogFactory> createDiaglogFactory(): DialogFactory {
        return when (F::class) {
            MaterialDialogFactory::class -> MaterialDialogFactory()
            CupertinoAlertDialog::class -> CupertinoDialogFactory()
            else -> throw IllegalArgumentException()
        }
    }
}


fun main(args: Array<String>) {
    val materialDialogFactory = DialogFactoryProvider().createDiaglogFactory<MaterialDialogFactory>()
    val materialAlertDialog = materialDialogFactory?.createAlertDialog()
    materialAlertDialog?.show()
}
