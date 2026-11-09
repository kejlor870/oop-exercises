package org.example;

import org.example.model.Member;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MemberTest {

    @Test
    void testMemberCreateNewMember(){
        String name = "Jan";
        Member newMember = new Member(name);

        String memberName = newMember.getName();

        assertEquals(name, memberName);
    }

    @Test
    void testMemberCreateNullName(){
        assertThrows(IllegalArgumentException.class, () -> {
           new Member(null);
        });
    }

    @Test
    void testMemberCreateBlankName(){
        assertThrows(IllegalArgumentException.class, () -> {
            new Member("  ");
        });
    }

    @Test
    void testMemberMembersUniqueId(){
        Member member1 = new Member("Jan");
        Member member2 = new Member("Ola");

        String idMember1 = member1.getUniqueId();
        String idMember2 = member2.getUniqueId();

        assertNotEquals(idMember1, idMember2);
    }
}
