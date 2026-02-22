import fs from 'node:fs';


export function writeToFile(filePath, text, append) {
  if (append) {
    try {
      fs.appendFileSync(filePath, text, 'utf-8');
    } catch (err) {
      console.error(err);
    }
  } else {
    try {
      fs.writeFileSync(filePath, text, 'utf-8');
    } catch (err) {
      console.error(err);
    }
  }
}