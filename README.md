# <center> Systèmes moblies
# <center> Laboratoire n°3 : Utilisation de données environnementales

## Balises NFC
https://www.thepolyglotdeveloper.com/2016/07/support-ibeacons-in-your-native-android-mobile-app/

### 2.4 Question
**Dans la manipulation ci-dessus, les tags NFC utilisés contiennent 4 valeurs textuelles codées en UTF-8 dans un format de message NDEF. Une personne malveillante ayant accès au porte-clés peut aisément copier les valeurs stockées dans celui-ci et les répliquer sur une autre puce NFC.**

**A partir de l’API Android concernant les tags NFC4, pouvez-vous imaginer une autre approche pour rendre plus compliqué le clonage des tags NFC ? Est-ce possible sur toutes les plateformes (Android et iOS), existe-il des limitations ? Voyez-vous d’autres possibilités ?**

Utiliser un id pour assurer l'authentification de la bonne personne avant le clonage des données pourrait constituer une solution. Certains tags NFC permettent une identification plus sûr via un ID, nous permettant d'avoir une meilleure sécurisation des données. Il faut cependant retenir que l'ID est une variable modifiable. Il serait donc possible de chercher à recupérer dans un premier temps l'ID du smartphone authorisé avant de répliquer son ID pour obtenir un accès aux données. Cette solution n'est donc que partielle.


Nous pourrions imaginer également une copie des données temporaire en lecture. En fonction de la priorité des données, nous authorieserons la lecture de celles-ci plus ou moins longtemps.

## Codes-bars

### 3.2 Question
**Comparer la technologie à codes-barres et la technologie NFC, du point de vue d'une utilisation dans des applications pour smartphones, dans une optique :**
- Professionnelle (Authentification, droits d’accès, stockage d’une clé)
Dans le cadre d'une authentification ou de droits d'accès, il est nécessaire d'utiliser la technologie NFC plutôt que celle du code barre. En effet, le code barre peut très facilement être dupliqué à l'aide d'une photocopieuse. Le NFC lui est sécurisé à l'aide d'un id précis associé à un badge donné.

-  Grand public (Billetterie, contrôle d’accès, e-paiement)
Le code barre convient bien à une billetterie. On pourra le rendre invalide une fois scanné une première fois facilement et son coût de production convient mieux que le NFC à ce type d'utilisation. Dans le cadre d'un payement, le code barre pourra servir à désigner le produit mais ne convient pas, au contraire de NFC, à une authentification pour effectuer un payement via internet.

-  Ludique (Preuves d'achat, publicité, etc.)


-  Financier (Coûts pour le déploiement de la technologie, possibilités de recyclage, etc.)
Le code barre est bien moins coûteux en terme de déploiement que la technologie NFC. Le code barre peut facilement être mis en place. Ce dernier ne nécessite au fond qu'une imprimante et d'un bon logiciel de dessin. Le NFC lui demande les capteurs ainsi que toute la mise en place de l'implémentation de ce dernier

En terme de recyclage, le code barre contient une information spécifique, nous forçant à avoir exactement le même type de ressource pour avoir un recyclage effectif. Il sera bien plus simple d'attribuer un nouveau code à la nouvelle ressource. Le NFC, quant à lui, est facilement recyclable, il suffit en effet simplement de faire pointer l'id sur la nouvelle ressource en question.

## Balises IBeacon

### 4.2 Question
**Les iBeacons sont très souvent présentés comme une alternative à NFC. Pouvez-vous commenter cette affirmation en vous basant sur 2-3 exemples de cas d’utilisations (use-cases) concrets (par exemple epaiement, second facteur d’identification, accéder aux horaires à un arrêt de bus, etc.).**

Les iBeacons et NFC fonctionnent de manière similaire, proposant un id permettant une authentification. Cependant, il y a un facteur notable qui fait différer les deux technologies: la distance. Le NFC fonctionne seulement lorsque le capteur se trouve à une distance réduite du terminal devant l'authentifier. Il permet donc d'authentifier de manière sûr l'utilisateur en question. Le iBeacon lui fonctionne dans une zone plus large. Il serait donc bien moins adapté pour des epayement, ce dernier le lançant automatiquement sans pour autant avoir le facteur de proximité comme confirmation de lancement.
Il conviendra donc bien pour connaître l'horaire des bus à un arrêt, permettant une utilisation moins fastidieuse de la technologie (on detectera automatiquement que le iBeacon est à proximité au contraire de NFC), nous renvoyant alors les horaires de l'arrêt concerné.

## Capteurs

### 5.2 Question
**Une fois la manipulation effectuée, vous constaterez que les animations de la flèche ne sont pas fluides, il va y avoir un tremblement plus ou moins important même si le téléphone ne bouge pas.**
**Veuillez expliquer quelle est la cause la plus probable de ce tremblement et donner une manière (sans forcément l’implémenter) d’y remédier.**
