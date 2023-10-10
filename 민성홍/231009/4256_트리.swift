//
//  main.swift
//  BackjoonUangel
//
//  Created by 민성홍 on 2023/10/09.
//  백준 4256: 트리
//  메모리: 69116KB
//  시간: 100ms

import Foundation

let T = Int(readLine()!)!

for _ in 0..<T {
    let n = Int(readLine()!)!
    let preorder = readLine()!.split(separator: " ").map { Int(String($0))! }
    let inorder = readLine()!.split(separator: " ").map { Int(String($0))! }
    var result = ""

    dfs(0, 0, n)

    func dfs(_ r: Int, _ s: Int, _ e: Int) {
        for i in s..<e{
            if preorder[r] == inorder[i] {
                dfs(r + 1, s, i)
                dfs(r + i - s + 1, i + 1, e)

                result += "\(preorder[r]) "
            }
        }
    }

    print(result)
}
