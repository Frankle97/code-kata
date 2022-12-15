import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatchers;

import java.io.File;
import java.io.IOException;

public class Masulsa {
    public static void main(String[] args) {
        try {
            new ByteBuddy().redefine(Moja.class)
                    .method(ElementMatchers.named("pullOut")).intercept(FixedValue.value("Rabbit!"))
                    .make().saveIn(new File("/Users/jaeyejung/IdeaProjects/frankle/code-kata/java-code-manipulation/target/classes/"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(new Moja().pullOut());
    }
}
