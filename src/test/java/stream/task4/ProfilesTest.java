package stream.task4;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
public class ProfilesTest {
    @Test
    public void whenCollectThenListAddress() {
        Profiles profiles = new Profiles();
        Address vorneg = new Address("Voroneg", "Lizikova", 70, 166);
        Address novgorod = new Address("Novgorod", "Nevskogo", 21, 7);
        List<Profile> profilesList = List.of(
                new Profile(new Address("Voroneg", "Lizikova", 70, 166)),
                new Profile(new Address("Novgorod", "Nevskogo", 21, 7))
        );
        List<Address> expect = List.of(novgorod, vorneg);
        List<Address> res = profiles.collect(profilesList);
        assertThat(res, is(expect));
    }

    @Test
    public void whenCollectThenListAddressDubl() {
        Profiles profiles = new Profiles();
        Address vorneg = new Address("Voroneg", "Lizikova", 70, 166);
        Address novgorod = new Address("Novgorod", "Nevskogo", 21, 7);
        List<Profile> profilesList = List.of(
                new Profile(new Address("Voroneg", "Lizikova", 70, 166)),
                new Profile(new Address("Novgorod", "Nevskogo", 21, 7)),
                new Profile(new Address("Novgorod", "Nevskogo", 21, 7))
        );
        List<Address> expect = List.of(novgorod, vorneg);
        List<Address> res = profiles.collect(profilesList);
        assertThat(res, is(expect));
    }
}