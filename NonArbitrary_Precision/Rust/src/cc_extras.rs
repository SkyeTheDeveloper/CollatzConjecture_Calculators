use std::fs;
use std::fs::OpenOptions;
use std::io;
use std::io::Write;

pub fn write_to_file(file_path: &str, text: &str, append: bool) -> io::Result<()>{

    if append {
        let mut file = OpenOptions::new()
            .append(true)
            .create(true)
            .open(file_path)?;
        file.write_all(text.as_bytes())?;
    } else {
        fs::write(file_path, text)?;
    }
    Ok(())
}