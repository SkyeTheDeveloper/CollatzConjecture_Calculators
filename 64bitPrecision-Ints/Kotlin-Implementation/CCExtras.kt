import java.io.File

fun clear() {
    print("\u001b[H\u001b[2J");
    System.out.flush();
}

fun writeToFile(path: String, text: String, append: Boolean) {
    if (append) {
        File(path).appendText(text);
    } else {
        File(path).writeText(text);
    }
}