//
//  main.swift
//  BackjoonUangel
//
//  Created by 민성홍 on 2023/08/11.
////// 백준 3040: 백설 공주와 일곱 난쟁이
////// 메모리: 79508KB
////// 시간: 16ms

import Foundation

var dwarfNums: [Int] = Array(repeating: 0, count: 9)

for i in 0..<9 {
    dwarfNums[i] = Int(readLine()!)!
}

let total: Int = dwarfNums.reduce(0, +)
let difference: Int = total - 100

for num in dwarfNums {
    let dwarf = difference - num

    if !dwarfNums.contains(dwarf) || dwarf == num {
        print(num)
    }
}
