# clodictearch 

Search algorithm meant for searching closest words based on Levenshtein distance

## Installation

```
git clone https://github.com/danorel/clodictearch
```

## Usage

1. To try a search algorithm for a small manually created dictionary of words, use:

```
lein run train-dict hello
```

2. To try a search algorithm for a large English dictionary of words, use:

```
lein run train-dict hello
```

3. To run tests which cover levenshtein distance evaluation and search algorithm based on Levenshtein index, use:

```
lein test
```

## License

Copyright © 2023 FIXME

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
