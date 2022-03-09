package com.rumblefish.recruitmenttask.domain

import spock.lang.Specification

class UserTest extends Specification {

    def "cannot create user with blank name"(String name) {
        when:
        User.from(name)

        then:
        def e = thrown(expectedExeption)
        e.message == expectedMessage

        where:
        name    || expectedExeption         || expectedMessage
        ""      || IllegalArgumentException || "name cannot be blank"
        null    || IllegalArgumentException || "name cannot be blank"
    }

    def "cannot create user with not alphabets name"(String name) {
        when:
        User.from(name)

        then:
        def e = thrown(expectedExeption)
        e.message == expectedMessage

        where:
        name    || expectedExeption         || expectedMessage
        "12312" || IllegalArgumentException || "name can contain only alphabets"
        "&^*()" || IllegalArgumentException || "name can contain only alphabets"
    }

    def "cannot assign null as id for user"() {
        given:
        User user = User.from("dummyName")

        when:
        user.assignId(null)

        then:
        def e = thrown(IllegalArgumentException)
        e.message == "id cannot be null"
    }

    def "greeting is returned after user is created"() {
        when:
        User user = User.from("dummyUser")

        then:
        user.greeting() == "Hello dummyUser"
    }
}
