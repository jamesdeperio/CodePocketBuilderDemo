/**
 * @author github.com/jamesdeperio
 * @version codepocket template builder v1.0
 */
package codepocket.jdp.codepocketbuilderdemo.global.app

class MainExceptionHandler : Thread.UncaughtExceptionHandler {
    override fun uncaughtException(t: Thread?, e: Throwable?) {
       /*
        try {
            val sw = StringWriter()
            val pw = PrintWriter(sw)
            e!!.printStackTrace(pw)
            val sStackTrace = sw.toString()
            val dir = File("FILE FOLDER LOCATION")
            if (!dir.exists()) dir.mkdir()
            val file = File("FILE LOCATION")
            val writer = FileWriter(file)
            writer.append(sStackTrace)
            writer.flush()
            writer.close()
        } catch (it: Exception) {
            it.printStackTrace()
        }*/
        System.exit(3)
    }
}
