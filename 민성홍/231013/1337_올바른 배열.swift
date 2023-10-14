//
//  main.swift
//  BackjoonUangel
//
//  Created by 민성홍 on 2023/10/13.
//  백준 1337: 올바른 배열
//  메모리: 69104KB
//  시간: 8ms

import Foundation

let N = Int(readLine() ?? "") ?? 0
var array = Array<Int>(repeating: 9987654321, count: 10001)
var index = 0
var count = 1
var result = 1

for i in 0..<N {
    array[i] = Int(readLine() ?? "") ?? 0
}
array.sort()

for i in 1..<N {
    count += 1
    while array[i] - array[index] > 4 {
        count -= 1
        index += 1
    }
    result = max(result, count)
}
if result > 5 {
    result = 5
}
print(5 - result)
