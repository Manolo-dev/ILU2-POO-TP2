# Village Gaulois

Dans ce TP nous allons voir l'architecture ECB (Entity-Control-Boundary) en utilisant le langage de programmation Java.

## ATTENTION
Étant un fervent détracteur du Java et ne souhaitant pas m'améliorer dans ce langage dégénéré, de nombreuses erreurs se trouveront dans ce dépôt. Je déconseille donc à quiconque ayant du retard ou ne souhaitant pas travailler d'utiliser ce dépôt comme source.

## Syntaxe stupide
  - Syntaxe verbeuse pour les opérations simples
  - Syntaxe qui mène à des lignes bien trop longues

### Inutilité des mots-clés
  - Usage redondant des mots-clés "final", "public", "static"...
  - Différence entre certains qualificatifs (final, const, static, readonly...)

### Possibilité de faire des erreurs
  - Pourquoi est-il possible de faire des attribut publiques ?
    On pourrait rendre les attributs privés par défaut et les rendre publics avec un mot-clé, idem pour les méthodes, qui pourrait être `public` par défaut. Ça éviterait de faire des erreurs du type ```Array.length```...
  - Pourquoi ne pas pouvoir surcharger les opérateurs ? C'est possible en C++ et en C#.
  - Pourquoi ne pas pouvoir définir des fonctions anonymes (simplement) ?

### Convention de nommage
  - La convention de nommage Java même souvent à avoir l'impression de lire du RAn.DoMCa_Se.
  - La convention de nommage Java mène à des noms de variables, classes et méthodes très longs.
  - La convention de nommage Java peut sembler incohérente, par exemple, on n'écrit pas `getLength()` mais `length()` pour obtenir la longueur d'une chaîne de caractères

## Performances inférieures
  - Surcharge causée par la machine virtuelle Java
  - Difficulté à optimiser le code Java (pas de pointeurs, pas de gestion clairement explicite de la mémoire, etc.)
  - Surcharge causée par la gestion de la mémoire et la collecte des déchets (garbage collection) dans Java
  - Comparaison des performances avec d'autres langages plus bas niveau (C, C++, Rust, etc.)
  - Difficulté extrème à manipuler les coeurs et les threads, la carte graphique et les périphériques, etc... (toujours très ironique pour un langage utilisé pour le développement de jeux vidéos)
  - Plantage régulier de la machine virtuelle Java due à la mauvaise allocation de la mémoire

## Mise à jour lente et peu adoptée
  - Réticence des entreprises à adopter rapidement de nouvelles versions de Java en raison de problèmes de compatibilité
  - Impact sur la sécurité des systèmes lorsque des correctifs et des mises à jour ne sont pas appliqués rapidement
  - Les mises à jour de Java sont souvent lourdes et prennent du temps
  - Certaines mises à jour de Java sont dangereuses et peuvent causer des problèmes de sécurité (beaucoup de programme utilise encore log4j 1.2, qui est vulnérable à une faille de sécurité particulièrement importante)

## Écosystème fragmenté
  - Multiples implémentations de Java (Oracle JDK, OpenJDK, etc.) avec des différences de compatibilité
  - Dépendance à des bibliothèques tierces pour des fonctionnalités de base, ce qui peut entraîner des incompatibilités
  - Bibliothèques non cross-platform, ironique pour un langage qui se veut cross-platform (qui crée même une machine virtuelle pour être cross-platform)

## Complexité accrue
  - La gestion de la mémoire en Java n'est pas assez explicite pour comprendre ce que l'on fait (ce qui mène à des fuites mémoires et des problèmes de performances), mais trop explicite pour ne pas être gérée automatiquement (comme en Python). On se retrouve donc avec les inconvénients des deux approches
  - Le cast quasi systématique des objets ne permet pas de savoir ce que l'on manipule
  - Besoin de comprendre les concepts avancés de la programmation orientée objet pour tirer pleinement parti de Java

## Éditeurs et librairies
  - Il existe beaucoup d'éditeurs Java, qui ont tous des conventions différentes et souvent très lourdes et longues à apprendre
  - Ces mêmes éditeurs sont souvent foncièrement mauvais: lent, lourd, peu intuitif, graphiquement depassé (souvent juste laid), etc.
  - Les métas-données d'un projet Java sont souvent très lourdes, très redondantes, contenue dans des fichiers XML (qui sont très lourds et peu intuitifs) et souvent mal gérées
  - La moindre petite erreur dans un fichier de métadonnées Java peut rendre le projet inutilisable par les éditeurs Java
  - Les librairies Java sont très pénibles à installer et à gérer, et les gestionnaires de dépendances Java sont catégoriquement nuls.
  - La redondance des librairies Java (souvent très lourdes et peu performantes) peut rendre difficile le choix de la bonne librairie pour un projet donné
  - Les librairies Java sont souvent très mal documentées, ce qui peut rendre difficile leur utilisation