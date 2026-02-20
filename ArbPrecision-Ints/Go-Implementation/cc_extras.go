package main

import (
	"fmt"
	"log"
	"os"
)

func Clear() {
	fmt.Print("\033[H\033[2J")
}

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