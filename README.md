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
![Multiple Condition Image](https://github.com/danielilievskii/SI_2024_lab2_223021/blob/master/multipleCondition.png)

### Објаснување на напишаните тестови
 
if (item.getPrice() > 300 && item.getDiscount() > 0 && item.getBarcode().charAt(0) == '0')
   * Комбинација FXX: allItems=[new Item("default", 1234, 250, 0)], payment=any - се испраќа листа со >=1 елементи каде вредноста на price на еден од нив е < 300 и се очекува овој if-statement да врати false, без да ги проверува останатите услови.
   * Комбинација TFX: allItems=[new Item("default", 1234, 350, 0)], payment=any - се испраќа листа со >=1 елементи каде вредноста на price на еден од нив е > 300, но dsicount = 0 и се очекува овој овој if-statement по проверка на вториот услов како неточен да врати false.
   * Комбинација TTF: allItems=[new Item("default", 1234, 350, 0.15)], payment=any - се испраќа листа со >=1 елементи каде вредноста на price на еден од нив е > 300, discount > 0, но првиот карактер од баркодот да биде различен од 0 и овој if-statement по враќање true na првите два услова за третиот да врати false, па така целиот да врати false.
   * Комбинација TTT: allItems=[new Item("default", 0234, 350, 0.15)], payment=any - се испраќа листа со >=1 елементи каде вредноста на price на еден од нив е > 300, discount > 0, и првиот карактер од баркодот да биде 0 и се очекува овој if-statement по враќање true na сите 3 услова, целиот да врати true.
