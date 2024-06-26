package main

import "fmt"

// ArraySize is the size of the hash table array
const ArraySize = 7

// HashTable will hold an array
type HashTable struct {
	array [ArraySize] * bucket
}

// bucket is a linked list in each slot of the hash table array
type bucket struct {
	head *bucketNode
}

//bucketNode is a linked list node that holds the key
type bucketNode struct {
	key string
	next *bucketNode
}

// Insert will take in  a key and add it to the hash table array
func (h *HashTable) Insert(key string) {
	index := hash(key)
	h.array[index].insert(key)
}

// Search will take in a key and return true if that key is stored in the hash table
func (h *HashTable) Search(key string) bool {
	index := hash(key)
	return h.array[index].search(key)
}

// Delete will take in a key and delete it from the hash table
func (h *HashTable) Delete(key string) {
	index := hash(key)
	h.array[index].delete(key)
}

// insert will take in a key, create a node with the key and insert the node in the bucket
func (b * bucket) insert(k string){
	if !b.search(k) {
		newNode := &bucketNode{key: k}
		newNode.next = b.head
		b.head = newNode
	} else {
		fmt.Println(k, "already exists")
	}
}
// Search
func (b *bucket) search(k string) bool {
	currentNode := b.head
	for currentNode != nil {
		if currentNode.key == k {
			return true
		}
		currentNode = currentNode.next
	}
	return false
}
// delete
func (b *bucket) delete(k string) {

	if b.head.key == k {
		b.head = b.head.next
		return
	}
	previoudNode := b.head
	for previoudNode.next != nil {
		if previoudNode.next.key == k {
			//delete
			previoudNode.next = previoudNode.next.next

		}
		previoudNode = previoudNode.next
	}
}

// Hash

func hash(key string) int {
	sum := 0
	for _, v := range key {
		sum += int(v)
	}
	return sum % ArraySize
}
// Init
func Init() *HashTable {
	result := &HashTable{}
	for i:= range result.array {
		result.array[i] = &bucket{}
	}
	return result
}

// 
func main() {
	hashTable := Init()
	fmt.Println(hashTable)
	list := []string{
		"ERIC",
		"KENNY",
		"KYLE",
		"STAN",
		"RANDY",
		"BUTTERTS",
	}
	for _, v := range list {
		hashTable.Insert(v)
	}
	fmt.Println(hashTable)

}