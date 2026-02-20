using System.IO;

namespace CollatzCalculatorExtras
{
    public class CCExtras
    {
        public static void WriteToFile(string filePath, string text, bool append)
        {
            if (append)
            {
                File.AppendAllText(filePath, text);
            }
            else
            {
                File.WriteAllText(filePath, text);
            }
        }
    }
}