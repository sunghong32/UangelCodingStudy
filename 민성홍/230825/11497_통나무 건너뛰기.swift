//
//  main.swift
//  BackjoonCodingTest
//
//  Created by 민성홍 on 2023/08/26.
////  백준 11497: 통나무 건너뛰기
////  메모리: 80640KB
////  시간: 132ms

import Foundation

let T = Int(readLine()!)!
var resultArray: [Int] = []

for _ in 0..<T {
    let N = Int(readLine()!)!
    var array = readLine()!.split(separator: " ").map { Int($0)! }
    array.sort()
    var result = 0
    for j in 2..<N {
        let c = array[j] - array[j - 2]
        result = max(c, result)
    }

    resultArray.append(result)
}

for i in 0..<resultArray.count {
    print(resultArray[i])
}
