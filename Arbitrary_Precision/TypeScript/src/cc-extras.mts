import * as fs from "node:fs";

export function writeToFile(filePath: string, text: string, append: boolean) {
  if (append) {
    try {
      fs.appendFileSync(filePath, text, "utf-8");
    } catch (err) {
      console.error(err);
    }
  } else {
    try {
      fs.writeFileSync(filePath, text, "utf-8");
    } catch (err) {
      console.error(err);
    }
  }
}
