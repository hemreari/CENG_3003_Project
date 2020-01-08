package main

import (
	"bufio"
	"fmt"
	"log"
	"os"
	"strings"
)

func main() {
	mailMap := make(map[string]string)

	file, err := os.Open("file.txt")
	if err != nil {
		log.Fatalf("Couldn't read the file: %v", err)
	}
	defer file.Close()

	scanner := bufio.NewScanner(file)
	for scanner.Scan() {
		line := scanner.Text()

		splittedLine := strings.Split(line, " ")
		name := splittedLine[0] + " " + splittedLine[1]
		mail := ""

		for _, element := range splittedLine {
			if strings.Contains(element, "@") {
				mail = element
				break
			}
		}
		mailMap[name] = mail
	}

	reader := bufio.NewReader(os.Stdin)
	for {
		fmt.Print("Enter Name: ")
		nameInputByte, _, err := reader.ReadLine()
		if err != nil {
			log.Fatalf("Error while getting input: %v", err)
		}

		nameInput := string(nameInputByte)

		userMail := mailMap[nameInput]

		if userMail == "" {
			fmt.Println(nameInput + "'s mail couldn't find.")
			continue
		}
		fmt.Println("User's Email: ", userMail)

	}

	if err := scanner.Err(); err != nil {
		log.Fatalf("Error scanner: %v", err)
	}
}
