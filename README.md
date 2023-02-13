# clodictearch 

Search algorithm meant for searching closest words based on Levenshtein distance

## Installation

```
git clone https://github.com/danorel/clodictearch
```

## Usage

1. To try a search algorithm for a small manually created dictionary with 10 words, use:

```
lein run custom-dictionary hello
```

2. To try a search algorithm for a large imported English dictionary with 400k+ words, use:

```
lein run english-dictionary hello
```

3. To run tests which cover levenshtein distance evaluation and search algorithm based on Levenshtein index, use:

```
lein test
```

## Results

1. On small manually created dictionary with 10 words:

```shell
"Timed find-closest-words: 33.032159 msecs"
Closest words to hello are:
[hellium heat]
```

2. On large imported dictionary with 400k+ English words:

```shell
"Timed find-closest-words: 33.032159 msecs"
Closest words to hello are:
[hellium heat]
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
