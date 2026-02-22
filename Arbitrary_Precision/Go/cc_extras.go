package main

import (
	"log"
	"os"
)

func WriteToFile(filePath string, text string, append bool) {
	flags := os.O_CREATE | os.O_WRONLY
	if append {
		flags |= os.O_APPEND
	} else {
		flags |= os.O_TRUNC
	}
	
	f, err := os.OpenFile(filePath, flags, 0644)
	if err != nil {
		log.Fatal(err)
	}
	defer f.Close()
	
	if _, err := f.WriteString(text); err != nil {
		log.Fatal(err)
	}
}