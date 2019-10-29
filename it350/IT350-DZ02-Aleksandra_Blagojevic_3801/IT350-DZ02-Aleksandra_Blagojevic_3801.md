## **Product**
model| maker|  type
:---:|:----:|:-----:
1001 |     A|   PC
3001 |     B|printer
2001 |     C|laptop

## **PC**
model| speed|    ram|   hd| price
:---:|:----:|:-----:|:---:|:----:
1001 |  2.66|   1024|  250|  2114
1002 |  1.42|    512|  250|   955
1003 |  3.20|   2048|  160|  1049

## **Laptop**
model| speed|    ram|  hd | price
:---:|:----:|:-----:|:---:|:----:
2001 |  2.00|   1024|  250|  2114
2002 |  1.73|    512|  250|   955
2003 |  1.83|   2048|  160|  1049

## **Printer**
model| color|   type| price
:---:|:----:|:-----:|:----:
3001 |  true|ink-jet|    99
3002 | false|  laser|   239
3003 |  true|  laser|   899

---
 simbol|                opis
:-----:|:------------------:
   &pi;|          projekcija
&sigma;|           selekcija
&times;|   dekartov proizvod 
  &cup;|               unija
  
---

#### 1. Pronaci sve brojeve modela crno-belih stampaca

&Pi;model(&sigma; color = false(Printer))

#### 2. Koji PC modeli imaju brzinu jednaku 50 GHz

&Pi;model(&sigma; speed = 50(PC))

#### 3. Pronađite parove proizvođača sa najmanje 2 razlicita računara (PC ili laptop) sa brzinama ne manjim od 2.80

(&Pi;maker(&sigma; type = PC &or; type = laptop(Product))) &times; (&sigma; speed &ge; 2.80(&Pi; speed(PC) &cup; &Pi; speed(Laptop)))


#### 4.Pronađite sve laptopove čija je cena veća od 1000

&Pi;(&sigma; price > 1000(Laptop))

#### 5.Pronađite proizvođače računara sa najmanje tri različite brzine



#### 6.Pronađite proizvođače računara koji prodaje tačno tri različita modela PC-a
---
#### 1.Sporazum u Vasingtonu iz 1921. godine zabranjuje koriscenje brodova tezih od 35000 tona. Pronaci brodove koji krse ovaj sporazum
#### 2.Pronaci sve zemlje koje su posedovale borbene brodove(bb) i borbene kruzere(bc)