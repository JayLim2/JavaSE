package com.jaylim.ch02.task14;

import java.util.ArrayList;

/**
 * Chapter 2
 * Task 14
 * Network (console task)
 */
public class Network {
    public class Member {
        private String name;
        private ArrayList<Member> friends;

        public Member(String name) {
            this.name = name;
            friends = new ArrayList<>();
        }

        public void leave() {
            //members.remove(this);
            unenroll(this);
        }

        public boolean belongsTo(Network n) {
            return Network.this == n;
        }
    }

    private ArrayList<Member> members;

    public Network() {
        members = new ArrayList<>();
    }

    public Member enroll(String name) {
        Member newMember = new Member(name);
        members.add(newMember);
        return newMember;
    }

    public void unenroll(Member member) {
        members.remove(member);
    }
}
