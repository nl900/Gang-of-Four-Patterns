

interface AlertDialog {
    fun show()
}

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

interface DialogFactory {
    fun createAlertDialog(): AlertDialog
}

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
    companion object {
        fun getDialogFactory(factoryType: String): DialogFactory? {
            return when (factoryType) {
                "material" -> MaterialDialogFactory()
                "cupertino" -> CupertinoDialogFactory()
                else -> null
            }
        }
    }
}

fun main(args: Array<String>) {
    val materialDialogFactory = DialogFactoryProvider.getDialogFactory("material")
    val materialAlertDialog = materialDialogFactory?.createAlertDialog()
    materialAlertDialog?.show()

    val cupertinoDialogFactory = DialogFactoryProvider.getDialogFactory("cupertino")
    val cupertinoAlertDialog = cupertinoDialogFactory?.createAlertDialog()
    cupertinoAlertDialog?.show()
}
