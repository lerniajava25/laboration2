# labboration2
Raytracer &amp; Domänmodellering (OOP)

Klasser:
Main - startar programmet, lägger till former, skickar strålar för alla pixlar och visar bilden via Java Swing
Scene - Har en lista för alla former. Frågar om strålarna träffar formerna och väljer färg från den närmaste träffen.
Shape - Innehåller ett interface som alla former följer. Kräver även metoderna hit(ray) som kontrollerar om strålen träffar formen och getColor() som returnerar formens färg.
Sphere - Beskriver en sfär med mittpunkt, radie och färg. Räknar ut om och var strålen träffar sfären.
Triangle - Beskriver en triangel med tre hörn och en färg. Kontrollerar om strålen träffar innanför triangelns kanter och framför kameran.
Vector3 - Lagrar tre koordinater: x, y, z. Används för positioner och riktningar och innehåller matematiska hjälpmetoder för träffberäkningarna.
Ray - Beskriver en stråle med en startpunkt (origin) och en riktning (dir).
Color - Lagrar en färg som RGB-värden.

För att lägga till en ny form:

1. Skapar en klass (med helst samma namn som din form ska ha) som implementerar Shape.
2. Implementerar hit(Ray ray) och getColor().
3. Lägger till objektet med scene.addShape(new "Din form") i Main.
