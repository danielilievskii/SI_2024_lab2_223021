# Втора лабораториска вежба по Софтверско инженерство
## Даниел Илиевски 223021
### Control Flow Graph
![CFG Image](https://github.com/danielilievskii/SI_2024_lab2_223021/blob/master/CFG.png)

### Цикломатска комплексност
Цикломатската комплексност на овој код е 10, истата ја добив преку формулата P+1, каде што P е бројот на предикатни јазли. Во случајoв P=9, па цикломатската комплексност изнесува 10.

### Тест случаи според критериумот Every branch
![Every Branch Image](https://github.com/danielilievskii/SI_2024_lab2_223021/blob/master/everyBranch.png)

### Објаснување на напишаните тестови
1. allItems=null, payment=any
   * Се праќа null листа и се очекува програмата да фрли RuntimeException().
2. allItems=[new Item(null, 2A45, 100, 0.15)], payment=any   
   * Се праќа листа со еден елемент каде баркодот содржи невалиден карактер и се очекува програмата да фрли RuntimeException()   
3. allItems=[new Item("default", null, 100, 0.15)], payment=any
   * Се праќа листа со еден елемент каде баркодот е null и се очекува програмата да фрли RuntimeException()   
4. allItems=[new Item("default1", 1234, 100, 0), new Item("default2", 0123, 350, 0.15)], payment=500
   * Се праќа непразна листа каде се очекува збирот на производите заедно со попустите да биде помал од payment и програмата да врати true.
5. allItems=[new Item("default1", 1234, 100, 0), new Item("default2", 0123, 350, 0.15)], payment=0
   * Се праќа истата листа од претходниот случај, но сега payment=0 каде се очекува збирот на производите заедно со попустите да биде поголем од payment и програмата да врати false.

### Тест случаи според критериумот Multiple condition
![Every Path Image](https://github.com/danielilievskii/SI_2024_lab2_223021/blob/master/multipleConditionNew.png)

### Објаснување на напишаните тестови
1. if (allItems == null)
   * Комбинација T: allItems=null, payment=any - се испраќа null листа каде се очекува овој if-statement да врати true
   * Комбинација F: allItems=[new Item(random values)], payment=any - се испраќа листа со >=1 елементи и се очекува овој if-statement да врати false

2. for(i=0, i < allItems.size(), i++)
   * Комбинација T && Комбинација F: allItems=[new Item(random values)], payment=any - се испраќа листа со >=1 елементи каде се очекува при изминување на листата, овој if-statement еднаш да врати true, а при изминување на сите елементи false 
   
3. if (item.getName() == null || item.getName().length() == 0)
   * Комбинација TX:allItems=[new Item(null, 2A45, 100, 0.15)], payment=any - се испраќа листа каде името на продуктот е null и се очекува овој if-statement да врати true
   * Комбинација FT: allItems=[new Item("", 2A45, 100, 0.15)], payment=any - се испраќа листа каде името е празен string и се очекува овој if-statement да врати повтортно true
   * Комбинација FF: allItems=[new item("Peter", 2A45, 100, 0.15)], payment=any - се испраќа листа каде името има некоја вредност и се очекува овој if-statement да врати false
4. if (item.getBarcode() != null)
   * Комбинација T: allItems=[new Item("default", 1234, 100, 0.15)], payment=any - се испраќа листа каде баркодот има некоја вредност различна од null и се очекува овој if-statement да врати true
   * Комбинација F: allItems=[new Item("default", null, 100, 0.15)], payment=any - се испраќа листа каде баркодот има вредност null и се очекува овој if-statement да врати false
5. for (int j = 0; j < item.getBarcode().length(); j++)
   * Комбинација T && Комбинација F: allItems=[new Item("default", 1234, 100, 0.15)], payment=any - се испраќа листа со >=1 елементи каде баркодот има >=1 карактер и се очекува при изминување на листата, овој if-statement еднаш да врати true, а по изминување на сите карактери од баркодот false
6. if (allowed.indexOf(c) == -1)
    * Комбинација T && Комбинација F: allItems=[newITem("default", 2A45, 100, 0.15)], payment=any - надоврзување на претходниот for циклус, се испраќа листа со >=1 елементи каде баркодот има >=1 карактер и притоа барем еден валиден и еден невалиден, при изминување на карактерите од баркодот, се очекува овој if-statement еднаш да врати true, а еднаш false.
7. if (item.getDiscount() > 0)
  * Комбинација T && Комбинација F: allItems=[new Item("default1", 1234, 100, 0), new User("default2", 0123, 350, 0.15)], payment=500 - се испраќа листа со >=1 елементи каде барем еден елемент има вредност за discount > 0, i барем еден discount = 0, па при изминување на сите елементи од листата овој if-statement еднаш ќе врати true, а еднаш false.
   
8. if (item.getPrice() > 300 && item.getDiscount() > 0 && item.getBarcode().charAt(0) == '0')
   * Комбинација FXX: allItems=[new Item("default", 1234, 250, 0)], payment=any - се испраќа листа со >=1 елементи и вредноста на price на еден од нив да биде < 300 и се очекува овој if-statement да врати false, без да ги проверува останатите услови.
   * Комбинација TFX: allItems=[new Item("default", 1234, 350, 0)], payment=any - се испраќа листа со >=1 елементи и вредноста на price на еден од нив да биде > 300, но dsicount = 0 и се очекува овој овој if-statement по проверка на вториот услов како неточен да врати false.
   * Комбинација TTF: allItems=[new Item("default", 1234, 350, 0.15)], payment=any - се испраќа листа со >=1 елементи и вредноста на price на еден од нив да биде > 300, discount > 0, но првиот карактер од баркодот да биде различен од 0 и овој if-statement по враќање true na првите два услова за третиот да врати false, па така целиот да врати false.
   * Комбинација TTT: allItems=[new Item("default", 0234, 350, 0.15)], payment=any - се испраќа листа со >=1 елементи и вредноста на price на еден од нив да биде > 300, discount > 0, и првиот карактер од баркодот да биде 0 и се очекува овој if-statement по враќање true na сите 3 услова, целиот да врати true.
9. if (sum <= payment)
   * Комбинација T: allItems=[new Item("default1", 1234, 200, 0)], payment=500 - се испраќа листа со >=1 елементи каде се очекува збирот на производите заедно со попустите да биде помал од payment и програмата за овој if-statement да врати true.
   * Комбинација F: allItems=[new Item("default1", 1234, 200, 0)], payment=0 - се испраќа листа со >=1 елементи каде се очекува збирот на производите заедно со попустите да биде поголчем од payment и програмата за овој if-statement да врати false.
