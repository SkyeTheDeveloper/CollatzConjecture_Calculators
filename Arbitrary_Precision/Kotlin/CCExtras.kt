import java.io.File

fun writeToFile(path: String, text: String, append: Boolean) {
    if (append) {
        File(path).appendText(text);
    } else {
        File(path).writeText(text);
    }
}