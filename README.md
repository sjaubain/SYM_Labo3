# <center> Systèmes moblies
# <center> Laboratoire n°3 : Utilisation de données environnementales

## Balises NFC

### 2.4 Question
**Dans la manipulation ci-dessus, les tags NFC utilisés contiennent 4 valeurs textuelles codées en UTF-8 dans un format de message NDEF. Une personne malveillante ayant accès au porte-clés peut aisément copier les valeurs stockées dans celui-ci et les répliquer sur une autre puce NFC.**

**A partir de l’API Android concernant les tags NFC4, pouvez-vous imaginer une autre approche pour rendre plus compliqué le clonage des tags NFC ? Est-ce possible sur toutes les plateformes (Android et iOS), existe-il des limitations ? Voyez-vous d’autres possibilités ?**

Utiliser un id pour assurer l'authentification de la bonne personne avant le clonage des données pourrait constituer une solution. Certains tags NFC permettent une identification plus sûr via un ID, nous permettant d'avoir une meilleure sécurisation des données. Il faut cependant retenir que l'ID est une variable modifiable. Il serait donc possible de chercher à recupérer dans un premier temps l'ID du smartphone authorisé avant de répliquer son ID pour obtenir un accès aux données. Cette solution n'est donc que partielle.

Nous pourrions imaginer également une copie des données temporaire en lecture. En fonction de la priorité des données, nous authorieserons la lecture de celles-ci plus ou moins longtemps.

## Codes-bars

### 3.2 Question
**Comparer la technologie à codes-barres et la technologie NFC, du point de vue d'une utilisation dans des applications pour smartphones, dans une optique :**
- Professionnelle (Authentification, droits d’accès, stockage d’une clé)

a
-  Grand public (Billetterie, contrôle d’accès, e-paiement)

a
-  Ludique (Preuves d'achat, publicité, etc.)

a
-  Financier (Coûts pour le déploiement de la technologie, possibilités de recyclage, etc.)

a

## Balises IBeacon

### 4.2 Question
**Les iBeacons sont très souvent présentés comme une alternative à NFC. Pouvez-vous commenter cette affirmation en vous basant sur 2-3 exemples de cas d’utilisations (use-cases) concrets (par exemple epaiement, second facteur d’identification, accéder aux horaires à un arrêt de bus, etc.).**

## Capteurs

### 5.2 Question
**Une fois la manipulation effectuée, vous constaterez que les animations de la flèche ne sont pas fluides, il va y avoir un tremblement plus ou moins important même si le téléphone ne bouge pas.**
**Veuillez expliquer quelle est la cause la plus probable de ce tremblement et donner une manière (sans forcément l’implémenter) d’y remédier.**
