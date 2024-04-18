package com.example.testingtesting123

import org.junit.Assert.*

import org.junit.Before
import org.junit.Test

class UniqueCollectionTest {

    lateinit var collection: UniqueCollection

    @Before
    fun setUp() {
        collection = UniqueCollection()
    }

    @Test
    fun addAnItem() {
        collection.addItem(Item("Item1"))
        val item = collection.get(0)
        assert(item.name == "Item1")
    }

    @Test
    fun addUniqueItem() {
        collection.addItem(Item("Item1"))
        collection.addItem(Item("item1"))
        collection.addItem(Item("Item2"))

        assert(collection.size() == 2)
    }

    @Test
    fun getItem() {
        val item0 = Item("Item 00")
        val item1 = Item("Item 01")

        collection.addItem(item0)
        collection.addItem(item1)

        assertEquals(item0, collection.get(0))
        assertEquals(item1, collection.get(1))
    }

    @Test
    fun removeItem() {
        val item0 = Item("Item 00")
        val item1 = Item("Item 01")

        collection.addItem(item0)
        collection.addItem(item1)

        val preRemoval = collection.size()
        collection.remove(item0)
        val postRemoval = collection.size()

        assert(1 == postRemoval && 2 == preRemoval)
        assertEquals(item0, collection.get(0))
    }

    @Test
    fun clearAllItems() {
        collection.addItem(Item("item1"))
        collection.addItem(Item("Item2"))

        val originalSize = collection.size()
        collection.clear()
        val newSize = collection.size();

        assert(originalSize == 2 && newSize == 0) {"Items not cleared"}
    }
}