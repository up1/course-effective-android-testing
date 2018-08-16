# Course Effective Android Testing

* แนวทางการทดสอบสำหรับ Android application
  * Why testing ?
  * ชนิดของการทดสอบ
    * JVM testing
  * Device testing
  * Local vs. on-device

* Workshop :: การพัฒนาและทดสอบ Android application
  * อธิบายความต้องการของ Application
  * เริ่มต้นด้วยการเขียน Unit test
  * TDD (Test-Driven Development)
    * RED-Green-Refactor
  * Code coverage
  * UI-less in-device
    * Setup
    * Null test
    * Count test
    * Lookup test
  * การทดสอบ UI Testing
    * Espresso
      * RecyclerView
      * Activity
      * Adapter
      * SharedPreference
* Hermetic Environment :: การจัดการ environment ต่าง ๆ ของการทดสอบ
  * Test doubles
    * Dummy
    * Stub
    * Spy
    * Mock
    * Fake
  * Dependency injection (DI)
  * Custom test runner
  * Test state

* Robot pattern
  * What vs. How ?
  * Separation of Concern
  * Mobile app architecture
    * Model-View-Presenter (MVP)
    * Model-View-ViewModel (MVVM)
    
* Mocking Tool
  * Mockito
  * instrument testing
