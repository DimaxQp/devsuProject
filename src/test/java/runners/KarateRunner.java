package runners;

import com.intuit.karate.junit5.Karate;

class KarateRunner {
    @Karate.Test
    Karate testKarate() {
        return Karate.run("classpath:features/karate").relativeTo(getClass());
    }
}
