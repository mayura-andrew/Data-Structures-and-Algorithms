package main

import (
	"fmt"

)

// AlphabetSize is the number of possible charactuers in the trie
const AlphabetSize = 26


// Node represents each node in the trie
type Node struct {
	children [26]*Node
	isEnd bool
}

// Trie represent a trie and has a pointer to the root node
type Trie struct {
	root *Node
}


// InitTrie will create new Trie
func InitTrie() *Trie {
	result := &Trie{root: &Node{}}
	return result
}


// Insert will take in a word and add it to the trie
func (t *Trie) Insert(w string) {
	wordLength := len(w)
	currentNode := t.root
	for i :=0; i < wordLength; i++ {
		charIndex := w[i] - 'a'
		if currentNode.children[charIndex] == nil {
			currentNode.children[charIndex] = &Node{}
		}
		currentNode=currentNode.children[charIndex]
	}
	currentNode.isEnd = true
}

// Search will take in  a word and RETURN true is that word is included in the trie
func (t *Trie) Search(w string) bool {
	wordLength := len(w)
	currentNode := t.root
	for i :=0; i < wordLength; i++ {
		charIndex := w[i] - 'a'
		if currentNode.children[charIndex] == nil {
			return false
		}
		currentNode = currentNode.children[charIndex]
	}
	if currentNode.isEnd == true {
		return true
	}
	return false
}


func main() {
	myTrie := InitTrie()

	toAdd := []string{
		"aragorn",
		"argon",
		"eragon",
		"oregon",
		"oregano",
		"oreo",
	}
	for _, v := range toAdd {
		myTrie.Insert(v)
	}


	fmt.Println(myTrie.Search("aragorn"))
	fmt.Println(myTrie.Search("wizard"))
}