/*
When there's generic processing in a class but want to vary the kind class.
It defines a method for creating objects which sublcasses override to change the type
of objects to create
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
