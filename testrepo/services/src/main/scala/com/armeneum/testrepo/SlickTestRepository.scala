package com.armeneum.testrepo

class SlickTestRepository() extends TestRepository {

  def getThing(): TestClass =
    TestClass(a = 1, b = "Hello, World!")
}
