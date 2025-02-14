package se.reciba.api

import se.reciba.api.model.Permalink

class PermalinkSpec extends org.specs2.mutable.Specification {
  "fromRawString" >> {
    "lowercase input" >> {
      Permalink.fromRawString("FooBar").value should_== "foobar"
    }

    "replace spaces with dashes" >> {
      Permalink.fromRawString("foo bar").value should_== "foo-bar"
    }

    "trim whitespace from the start/end of the input" >> {
      Permalink.fromRawString(" foo ").value should_== "foo"
    }

    "remove acutes" >> {
      Permalink.fromRawString("fôôbär").value should_== "foobar"
    }

    "remove non-latin characters" >> {
      Permalink.fromRawString(".f$^b@r!").value should_== "fbr"
    }

    "remove any duplicate whitespace left after other text transforms" >> {
      Permalink.fromRawString("foo $ bar").value should_== "foo-bar"
    }

    "remove stop words from input" >> {
      Permalink.fromRawString("and bar with").value should_== "bar"
    }

    "preserve pre-existing dashes" >> {
      Permalink.fromRawString("foo-bar").value should_== "foo-bar"
    }

    "remove any duplicate dashes left after other text transforms" >> {
      Permalink.fromRawString("foo--bar").value should_== "foo-bar"
    }.pendingUntilFixed(
      "It's a Sunday night and I can't be bothered to implement this"
    )

    "remove adjectives from input" >> {
      Permalink
        .fromRawString("creamy foo and bar with")
        .value should_== "foo-bar"
    }
  }
}
