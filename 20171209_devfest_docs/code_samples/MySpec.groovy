import pl.devfest.AgeValidator
import spock.lang.Specification

class MySpec extends Specification {

    def "should validate human age range"() {
        given:
        def ageValidator = new AgeValidator()

        expect:
        // tag::ageValidator[]
        ageValidator.isValid(-10) == false
        ageValidator.isValid(10) == true
        // end::ageValidator[]
        ageValidator.isValid(150) == false
    }
}
