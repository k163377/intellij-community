// ERROR: The label '@OuterLoop1' does not denote a loop
public class TestClass {
    companion object {
        public fun main(args: Array<String>) {
            run {
                var i = 1
                @OuterLoop1 @OuterLoop2 while (i < 1000) {
                    run {
                        var j = 1
                        @InnerLoop while (j < 100) {
                            if (j == 3) {
                                j *= 3
                                continue@InnerLoop
                            }
                            if (i == j) {
                                i *= 2
                                continue@OuterLoop1
                            }
                            System.err.println(j)
                            if (j == 9) {
                                j *= 3
                                continue
                            }
                            j *= 3
                        }
                    }
                    i *= 2
                }
            }
        }
    }
}

fun main(args: Array<String>) = TestClass.main(args)
